class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 결과 값인 행렬을 새롭게 정의한다.
        int[][] arr = new int[arr1.length][arr2[0].length];
        // 2. 행렬의 곱을 구현한다.
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = 0;
                for(int k = 0; k < arr1[i].length; k++){
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }
}