package leetcode.SystemDesign;

/**
 * @auther : wangyufei
 * @date : 2022-03-18
 * <p>
 * 你的任务是为一个很受欢迎的银行设计一款程序，以自动化执行所有传入的交易（转账，存款和取款）。银行共有 n 个账户，编号从 1 到 n 。每个账号的初始余额存储在一个下标从 0 开始的整数数组 balance 中，其中第 (i + 1) 个账户的初始余额是 balance[i] 。
 * <p>
 * 请你执行所有 有效的 交易。如果满足下面全部条件，则交易 有效 ：
 * <p>
 * 指定的账户数量在 1 和 n 之间，且
 * 取款或者转账需要的钱的总数 小于或者等于 账户余额。
 * 实现 Bank 类：
 * <p>
 * Bank(long[] balance) 使用下标从 0 开始的整数数组 balance 初始化该对象。
 * boolean transfer(int account1, int account2, long money) 从编号为 account1 的账户向编号为 account2 的账户转帐 money 美元。如果交易成功，返回 true ，否则，返回 false 。
 * boolean deposit(int account, long money) 向编号为 account 的账户存款 money 美元。如果交易成功，返回 true ；否则，返回 false 。
 * boolean withdraw(int account, long money) 从编号为 account 的账户取款 money 美元。如果交易成功，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simple-bank-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Bank2043 {
    private long[] moneys;
    private int accounts;

    public Bank2043(long[] balance) {
        moneys = balance;
        accounts = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (isValidAccount(account1) && isValidAccount(account2)) {
            if (moneys[account1 - 1] >= money) {
                moneys[account1 - 1] -= money;
                moneys[account2 - 1] += money;
                return true;
            }
        }
        return false;
    }

    private boolean isValidAccount(int account) {
        return account > 0 && account <= accounts;
    }

    public boolean deposit(int account, long money) {
        if (isValidAccount(account)) {
            moneys[account - 1] += money;
            return true;
        }
        return false;

    }

    public boolean withdraw(int account, long money) {
        if (isValidAccount(account)) {
            if (moneys[account - 1] >= money) {
                moneys[account - 1] -= money;
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        long[] balance = {10, 100, 20, 50, 30};
        Bank2043 bank = new Bank2043(balance);
        boolean r1 = bank.withdraw(3, 10);
        boolean r2 = bank.transfer(5, 1, 20);
        boolean r3 = bank.deposit(5, 20);
        boolean r4 = bank.transfer(3, 4, 15);
        boolean r5 = bank.withdraw(10, 50);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
    }
}
