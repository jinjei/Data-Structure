#include <stdio.h>

void print_arr(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ",arr[i]);
    }
    printf("\n");
}

void insertion_sort(int arr[], int n)
{
    int i, j, key;
    for (i = 1; i < n; i++)
    {
        key = arr[i];
        j = i - 1;
        while (j >= 0 && arr[j] > key)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
        print_arr(arr, n);
    }
    
}

int main()
{
    int a[] = {10,11,8,0,9,6,5,2,3,1};
    print_arr(a, 10);
    insertion_sort(a, 10);
}