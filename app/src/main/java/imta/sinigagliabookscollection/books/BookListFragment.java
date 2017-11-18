package imta.sinigagliabookscollection.books;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import imta.sinigagliabookscollection.R;
import imta.sinigagliabookscollection.model.Book;
import imta.sinigagliabookscollection.service.BookService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Steeve Sinigaglia on 18/11/2017.
 */

public class BookListFragment extends Fragment implements BookAdapter.OnBookSelectedListener {

    private OnBookSelectedListener listener;
    private RecyclerView recyclerView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBookSelectedListener) {
            listener = (OnBookSelectedListener) context;
        } else {
            throw new RuntimeException("Activity must implements OnBookSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.library_list, container, false);
        recyclerView = view.findViewById(R.id.bookRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        recyclerView.setAdapter(new BookAdapter(LayoutInflater.from(BookListFragment.this.getContext()), this));

        manageBookService();
        return view;
    }

    private void manageBookService() {
        //build retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        //Create the service
        BookService bookService = retrofit.create(BookService.class);
        bookService.listBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                List<Book> list = response.body();
                ((BookAdapter) recyclerView.getAdapter()).setBooks(list);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBookSelected(Book book) {
        listener.onBookSelected(book);
    }

    public interface OnBookSelectedListener {
        void onBookSelected(Book book);
    }
}
