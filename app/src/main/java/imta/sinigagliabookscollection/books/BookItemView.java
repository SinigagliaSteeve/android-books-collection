package imta.sinigagliabookscollection.books;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.TextView;

import imta.sinigagliabookscollection.R;

/**
 * Created by Steeve Sinigaglia on 18/11/2017.
 */

public class BookItemView extends ConstraintLayout {
    private TextView titleTextView;
    private TextView priceTextView;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        titleTextView = findViewById(R.id.titleTextView);
        priceTextView = findViewById(R.id.priceTextView);
    }

    public void bindView(Book book) {
        titleTextView.setText(book.getTitle());
        priceTextView.setText(String.valueOf(book.getPrice()) + " €");
    }


}
