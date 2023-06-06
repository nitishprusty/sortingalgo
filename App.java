public class App{
    //print elements
    static void print(int [] arr){
        for(Integer i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] arr = {12,5,64,8,96,2};
        
        Bubblesort(arr);
        selectionsort(arr);
        insertionsort(arr);

        Divide(arr, 0, arr.length-1);
        print(arr);
        quicksort(arr, 0, arr.length-1);
        print(arr);
        
    }
    //Bubble sort

    static void Bubblesort(int [] arr){
        int temp,flag;
        for(int i = 0;i<arr.length;i++){
            flag = 0;
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0){
                break;
            }
        }
        print(arr);
    }

    //selection sort

    static void selectionsort(int [] arr){
        int temp,min;
        for(int i = 0;i<arr.length;i++){
            min = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        print(arr);
    }

    //insertion sort
    static void insertionsort(int [] arr){
        int temp,j;
        for(int i = 1;i<arr.length;i++){
            temp = arr[i];
            j = i;
            while(j > 0 && arr[j - 1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        print(arr);

    }

    //merge sort
    static void Divide(int [] arr,int low,int high){
        if(low < high){
            int mid = (low + high)/2;
            Divide(arr, low, mid);
            Divide(arr, mid + 1, high);
            merge(arr,low,mid,high);
        }
    }
    static void merge(int [] arr,int low,int mid,int high){
        int i = low;
        int j = mid + 1;
        int  k = low;
        int [] temp = new int[arr.length];
        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        if(i > mid){
            while(j <= high){
                temp[k++] = arr[j++];
            }
        }else{
            while(i <= mid){
                temp[k++] = arr[i++];
            }
        }

        for(k = low;k<=high;k++){
            arr[k] = temp[k];
        }
    }

    //quicksort
    static void quicksort(int [] arr,int low,int high){
        if(low < high){
            int pivotindex = partition(arr,low,high);
            quicksort(arr, low, pivotindex - 1);
            quicksort(arr, pivotindex + 1, high);
        }
    }
    static int partition(int [] arr,int low,int high){
        int pivot = arr[high];
        int i = low - 1; //-1 default
        for(int j = low;j<=high;j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }
    static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}