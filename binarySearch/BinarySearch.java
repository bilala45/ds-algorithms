public class BinarySearch {

  public static int binarySearch(int[] searchArr, int value) {
    int start = 0;
    int end = searchArr.length - 1;

    while (start <= end) {
      int mid = start + (end - start)/2;

      if (searchArr[mid] == value){
        return mid;
      } else if (searchArr[mid] < value) {
        start = mid + 1;
      } else if (searchArr[mid] > value) {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] test = {0,2,4,5,6,7,9,10};
    System.out.println(binarySearch(test, 2));
  }
}
