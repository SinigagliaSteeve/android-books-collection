package imta.sinigagliabookscollection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        //build retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Create the service
        BookService bookService = retrofit.create(BookService.class);

        //Timber tree.
        Timber.plant(new Timber.DebugTree());

        bookService.listBooks().enqueue(new Callback<List<Book>>() {
            @SuppressLint("TimberArgCount")
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                List<Book> list = response.body();
                for (Book book : list) {
                    Timber.i("Book : " + book);
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }
}
