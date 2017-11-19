package imta.sinigagliabookscollection.books;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import imta.sinigagliabookscollection.R;
import imta.sinigagliabookscollection.model.Book;
import timber.log.Timber;

/**
 * Created by Steeve Sinigaglia on 18/11/2017.
 */

public class BookDetailFragment extends Fragment {

    private TextView title;
    private TextView price;
    private TextView isbn;
    private TextView synopsis;
    private ImageView cover;

    private Book book;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_detail, container, false);
        title = view.findViewById(R.id.title);
        price = view.findViewById(R.id.price);
        isbn = view.findViewById(R.id.isbn);
        synopsis = view.findViewById(R.id.synopsis);
        cover = view.findViewById(R.id.cover);

        synopsis.setMovementMethod(new ScrollingMovementMethod());
        if (getArguments() != null) {
            bindView(getArguments().getParcelable(BookBundleCode.BOOK_KEY));
        }

        return view;
    }

    public Book getBook() {
        return book;
    }

    private void bindView(Book book) {
        this.book = book;
        if (book == null) return;
        this.title.setText(book.getTitle());
        this.price.setText(book.getPrice() + " €");
        this.isbn.setText(book.getIsbn());
        this.synopsis.setText(book.getSynopsis()[0]);

        Glide.with(this)
                .load(book.getCover())
                .into(cover);
    }
}
