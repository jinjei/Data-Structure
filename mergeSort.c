#include <stdio.h>
#include <stdlib.h>

//helper function, to print the array
void print_arr(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    putchar('\n');
}

//merge
void merge(int arr[], int tempArr[], int left, int mid, int right)
{
    int p1 = left;
    int p2 = mid + 1;
    int i = 0;
    while (p1 <= mid && p2 <= right)
    {
        if (arr[p1] < arr[p2])
            tempArr[i++] = arr[p1++];
        else 
            tempArr[i++] = arr[p2++];
    }
    while (p1 <= mid)
    {
        tempArr[i++] = arr[p1++];
    }
    while (p2 <= right)
    {
        tempArr[i++] = arr[p2++];
    }
    
    for (int j = 0; j < i; j++)
    {
        arr[left++] = tempArr[j];
    }
    
}

//mergesort
void msort(int arr[], int tempArr[], int left, int right)
{
    if (left < right)
    {
        int mid = (left + right) / 2;
        msort(arr, tempArr, left, mid);
        msort(arr, tempArr, mid + 1, right);
        merge(arr, tempArr, left, mid, right);
    }
    
}

//entrance of mergesort
void mergeSort(int arr[], int n)
{
    int* tempArr = (int*)malloc(n * sizeof(int));
    if (tempArr) //molloc succeed
    {
        msort(arr, tempArr, 0, n - 1);
        free(tempArr);
    } 
    else
    {
        printf("Error: failed to allocate memory");
    }
    
}

int main()
{
    int arr[] = {9,5,2,7,12,8,3,1,16,11};
    int n = 10;
    print_arr(arr, n);

    mergeSort(arr, n);
    print_arr(arr, n);

    return 0;
}