package BinarySearch;

public class AllocateBooks {


    public int books(int[] books, int no_of_children) {
        int l = 1;
        int h = 0;
        for (int item : books) {
            h += item;
            l = Math.max(item, l);
        }

        int ans = -1;

        if (no_of_children <= books.length)
            while (l <= h) {

                int mid = l + (h - l) / 2;


                if (isPossible(books, mid, no_of_children)) {
                    ans = mid;
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }

            }
        return ans;
    }


    boolean isPossible(int books[], int max_pages, int total_no_of_children) {

        int curr_pages = 0;

        int books_distributed = 0;
        int no_of_children_got_book = 0;

        int total_no_of_books = books.length;

        while (books_distributed < total_no_of_books && no_of_children_got_book < total_no_of_children) {

            no_of_children_got_book++;
            curr_pages = 0;

            while (books_distributed < total_no_of_books
                    && curr_pages + books[books_distributed] <= max_pages) {
                curr_pages += books[books_distributed];
                books_distributed++;
            }

        }

        //all books finised and all child got book
        if (books_distributed == total_no_of_books)
            return true;
        else return false;
        //all books not finished

        // all child not got book
    }
}
