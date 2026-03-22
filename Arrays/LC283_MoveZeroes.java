class LC283_MoveZeroes {
    public void moveZeroes(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        LC283_MoveZeroes obj = new LC283_MoveZeroes();
        int[] arr = { 0, 1, 0, 3, 12 };
        obj.moveZeroes(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}