public class Bank
{
    private String _bankName;
    private int _bankCode;
    private BankAccount _account1;
    private BankAccount _account2;

    public Bank(String bankName, int bankCode)
    {
        _bankName = bankName;
        _bankCode = bankCode;
    }

    public void setAccounts(BankAccount a, BankAccount b)
    {
        _account1 = a;
        _account2 = b;
    }

    public double getTotalBalance()
    {
        return _account1.getBalance() + _account2.getBalance();
    }

    public String getBankInfo()
    {
        String toReturn = String.format("Bank: %s (Code: %d) \nAccount 1:%s \n Account 2: %s", _bankName, _bankCode, _account1.getAccountInfo(), _account2.getAccountInfo());
        return toReturn;
    }

    public String getBankName()
    {
        return _bankName;
    }
}