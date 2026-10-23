class Solution {
    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        mergeSort(nums,left,right);
        return nums;
    }

    public static void mergeSort(int[] nums,int left, int right){
        if(left>=right){
            return;
        }

        int mid = left +(right-left)/2;

        mergeSort(nums,left,mid);

        mergeSort(nums,mid+1,right);

        merge(nums,left,right,mid);


    }

    public static void merge(int[] arr, int left, int right,int mid){
        int n1=mid-left+1;
        int n2=right-mid;

        int[] leftArray = new int[n1];
        int[] rightArray= new int[n2];

         // Copy values into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i=0;
        int j=0;
        int k=left;

        while(i<n1 && j<n2){
            if(leftArray[i]<=rightArray[j]){
                arr[k++]=leftArray[i++];
            }else{
                arr[k++]=rightArray[j++];
            }
        }

        while(i<n1){
            arr[k++]=leftArray[i++];
        } 

        while(j<n2){
            arr[k++]=rightArray[j++];
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna