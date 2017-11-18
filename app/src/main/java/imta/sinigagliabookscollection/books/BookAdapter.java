package imta.sinigagliabookscollection.books;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import imta.sinigagliabookscollection.R;
import imta.sinigagliabookscollection.model.Book;

/**
 * Created by Steeve Sinigaglia on 18/11/2017.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    public interface OnBookSelectedListener {
        void onBookSelected(Book book);
    }

    private LayoutInflater inflater;
    private List<Book> books;
    private OnBookSelectedListener listener;

    public BookAdapter(LayoutInflater inflater, OnBookSelectedListener listener) {
        this.inflater = inflater;
        this.books = new ArrayList<>();
        this.listener = listener;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @Override
    public BookAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.card_item_book, parent, false));
    }

    @Override
    public void onBindViewHolder(BookAdapter.MyViewHolder holder, int position) {
        final Book book = books.get(position);
        ((BookItemView) holder.itemView).bindView(book);
        holder.cardBook.setOnClickListener(view -> {
            listener.onBookSelected(book);
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        protected CardView cardBook;


        public MyViewHolder(View itemView) {
            super(itemView);
            cardBook = itemView.findViewById(R.id.card_book);
        }
    }
}