#include <stdio.h>
void print_arr(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ",arr[i]);
    }
    printf("\n");
}

void swap(int *a, int *b) 
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void selection_sort(int arr[], int n)
{
    int i, j ,minIndex;
    for (int i = 0; i < n; i++)
    {
        minIndex = i;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] < arr[minIndex])
                minIndex = j;
            
        }
        swap(&arr[minIndex], &arr[i]);
        print_arr(arr,n);
    }
    
}

int main()
{
    int arr[] = {16,5,7,6,1,8,2,11,9,3,11};
    print_arr(arr,11);

    selection_sort(arr,11);
    
    return 0;
}