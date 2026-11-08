public class Main
{
    public static void main(String[] args)
    {
        BankAccount first = new BankAccount("Yoad", 1704);
        BankAccount second = new BankAccount("Yonatan", 0);
        System.out.println("Id of first account: " + first.getAccountId());
        System.out.println("ID of second account: "+ second.getAccountId());

        first.deposit(500);
        second.withdraw(200);

        first.transferTo(second, 300);

        boolean overWithdraw = second.withdraw(5000);
        String toPrint = String.format("Withdraw above balance gave a result of: %b and the balance after the change was %.2f", overWithdraw, second.getBalance());
        System.out.println(toPrint);

        System.out.println(first.getAccountInfo());
        System.out.println(second.getAccountInfo());

        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());


        System.out.println("next id view without change: " + BankAccount.getNextAccountId());
        BankAccount third = new BankAccount("Matan", 676);
        System.out.println("id of third account is: " + third.getAccountId());

        boolean testDeposit = first.deposit(-100);
        boolean testTransfer = first.transferTo(first, 50);
        System.out.println("Negative deposit succeeded: " + testDeposit);
        System.out.println("Self transfer succeeded: " + testTransfer);

        // 11. Create a Bank, link two accounts, and print bank info and total balance
        Bank testBank = new Bank("Yoad's bank", 1704);
        testBank.setAccounts(first, second);
        System.out.println(testBank.getBankInfo());
        System.out.println("Total balance in bank: " + testBank.getTotalBalance());
    }
}