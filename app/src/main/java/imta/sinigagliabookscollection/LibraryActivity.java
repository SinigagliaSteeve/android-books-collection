package imta.sinigagliabookscollection;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import imta.sinigagliabookscollection.books.BookBundleCode;
import imta.sinigagliabookscollection.books.BookDetailFragment;
import imta.sinigagliabookscollection.books.BookListFragment;
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

        this.detailFragment = new BookDetailFragment();
        //Timber tree.
        Timber.plant(new Timber.DebugTree());

//        this.manageBookService();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.books, new BookListFragment(), BookListFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onBookSelected(Book book) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Timber.i("simule click");
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(BookBundleCode.BOOK_KEY, book);
            detailFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.books, detailFragment, BookDetailFragment.class.getSimpleName())
                    .addToBackStack(BookDetailFragment.class.getSimpleName())
                    .commit();

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
