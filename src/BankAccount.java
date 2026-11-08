public class BankAccount
{
    private int _accountId;
    private String _ownerName;
    private double _balance;
    private boolean _isActive;
    private static int _nextId = 1000;
    private static int _totalAccounts = 0;

    public BankAccount(String ownerName)
    {
        _accountId = _nextId;
        _nextId++; /// first use id and then move to the next
        _totalAccounts++;
        _ownerName = ownerName;
        _balance = 0;
        _isActive = true;
    }

    public BankAccount(String ownerName, double initialBalance)
    {
        _accountId = _nextId;
        _nextId++;
        _totalAccounts++;
        _ownerName = ownerName;
        _isActive = true;
        if (initialBalance < 0) _balance = 0;
        else _balance = initialBalance;
    }

    public boolean deposit(double amount)
    {
        if (_isActive && isValidAmount(amount))
        {
            _balance += amount;
            return true;
        }
        else return false;
    }

    public boolean withdraw(double amount)
    {
        if (_isActive && isValidAmount(amount) && amount <= _balance)
        {
            _balance -= amount;
            return true;
        }
        else
            return false;
    }

    public boolean transferTo(BankAccount destination, double amount)
    {
        if (destination != null && _isActive && destination._accountId != _accountId && destination._isActive && isValidAmount(amount) && amount <= _balance)
        {
            _balance -= amount;
            destination._balance += amount;
            return true;
        }
        else return false;
    }
    public boolean closeAccount()
    {
        if (_isActive && _balance == 0)
        {
            _isActive = false;
            return true;
        }
        else return false;
    }

    public String getAccountInfo()
    {
        String state;
        String toReturn;
        if (_isActive)
        {
            state = "Active";
            toReturn = String.format("The account belonging to %s (ID: %d) is %s and has a balance of %.2f.", _ownerName, _accountId, state, _balance);
        }
        else
        {
            state = "Closed";
            toReturn = String.format("The account belonging to %s (ID: %d) is %s!", _ownerName, _accountId, state);
        }
        return toReturn;
    }

    public int getAccountId()
    {
        return _accountId;
    }

    public String getOwnerName()
    {
        return _ownerName;
    }

    public void setOwnerName(String ownerName)
    {
        if (ownerName != null && !ownerName.equals("")) _ownerName = ownerName;
    }

    public double getBalance()
    {
        return _balance;
    }

    public boolean isActive()
    {
        return _isActive;
    }

    public static int getTotalAccounts()
    {
        return _totalAccounts;
    }

    public static boolean isValidAmount(double amount)
    {
        if (amount > 0) return true;
        else return false;
    }

    public static int getNextAccountId()
    {
        return _nextId;
    }
}