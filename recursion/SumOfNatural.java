public class SumOfNatural {

  public static int sumNaturals(int n) {
    if (n > 0) {
      return n + sumNaturals(n-1);
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(sumNaturals(3)); // 6
    System.out.println(sumNaturals(0)); // 0
    System.out.println(sumNaturals(5)); // 15
  }
}
