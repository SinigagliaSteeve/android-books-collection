package imta.sinigagliabookscollection.books;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import imta.sinigagliabookscollection.R;
import imta.sinigagliabookscollection.model.Book;
import timber.log.Timber;

/**
 * Created by Steeve Sinigaglia on 18/11/2017.
 */

public class BookDetailFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_detail, container, false);
        Timber.i("Book detail : " + getArguments().getParcelable(BookBundleCode.BOOK_KEY));
        return view;
    }
}
