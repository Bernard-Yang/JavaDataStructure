class _307 {

    private int[] sum; //sum[i] 存储前i个元素和

    public _307(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i =1 ; i < nums.length ; i ++){
            sum[i] = sum[i -1 ] + nums[i -1];
        }
    }

    public void update(int i, int val){


    }


    public int sumRange(int i, int j) {

        return sum[j + 1] - sum[i];
    }
}
