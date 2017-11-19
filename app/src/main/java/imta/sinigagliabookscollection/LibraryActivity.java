package imta.sinigagliabookscollection;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.Toast;

import imta.sinigagliabookscollection.books.BookBundleCode;
import imta.sinigagliabookscollection.books.BookDetailFragment;
import imta.sinigagliabookscollection.books.BookListFragment;
import imta.sinigagliabookscollection.books.DetailsBookActivity;
import imta.sinigagliabookscollection.model.Book;
import timber.log.Timber;

/**
 * Created by Steeve Sinigaglia on 18/11/2017.
 */

public class LibraryActivity extends AppCompatActivity implements BookListFragment.OnBookSelectedListener {

    private BookDetailFragment detailFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);

//        this.bookListFragment = new BookListFragment();
        this.detailFragment = new BookDetailFragment();
        //Timber tree.
        Timber.plant(new Timber.DebugTree());

//        this.manageBookService();


//        if (bookListFragment == null) {
//            bookListFragment = new BookListFragment();
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.books, bookListFragment, BookListFragment.class.getSimpleName())
//                    .commit();
//        }

    }


    @Override
    public void onBookSelected(Book book) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            if (detailFragment == null || detailFragment.getBook() != book) {
                detailFragment = new BookDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable(BookBundleCode.BOOK_KEY, book);
                detailFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.bookDetail, detailFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent();

            // explicitly set the activity context and class
            // associated with the intent (context, class)
            intent.setClass(this, DetailsBookActivity.class);

            // pass the current position
            intent.putExtra(BookBundleCode.BOOK_KEY, book);

            startActivity(intent);
//            Bundle bundle = new Bundle();
//            bundle.putParcelable(BookBundleCode.BOOK_KEY, book);
//            detailFragment.setArguments(bundle);
//
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.books, detailFragment, BookDetailFragment.class.getSimpleName())
//                    .addToBackStack(BookDetailFragment.class.getSimpleName())
//                    .commit();

        }
    }

//    @Override
//    public void onDetail() {
//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Timber.i("simule click");
//        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.books, detailFragment, BookDetailFragment.class.getSimpleName())
//                    .addToBackStack(BookDetailFragment.class.getSimpleName())
//                    .commit();
//
//        }
//
//    }

}
