// https://en.wikipedia.org/wiki/Bubble_sort
// http://mrhaki.blogspot.com/2015/03/groovy-goodness-swapping-elements-in.html
// Very cool http://sorting.at/
// Cool to show https://www.toptal.com/developers/sorting-algorithms
// https://www.youtube.com/watch?v=ZZuD6iUe3Pc
//
// Selection sort: http://www.cs.kzoo.edu/cs210/Labs/Recursion/recursiveSelSort.html
//
// Quicksort: https://en.wikipedia.org/wiki/Quicksort

List input = [99, 13, 100, 1, 5, -12]

println input
println ''

bubbleSort(input, input.size())

println ''
println input

def bubbleSort(List list, int n) {
    if (n == 1) {
        return
    }

    for (int i = 0; i < n - 1; i++) {
        if (list[i] > list[i + 1]) {
            list.swap(i, i + 1)
        }
    }

    println list

    bubbleSort(list, n - 1)
}
