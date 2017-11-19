package imta.sinigagliabookscollection.books;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Steeve Sinigaglia on 19/11/2017.
 */

public class DetailsBookActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //we don't need this activity.
            finish();
            return;
        }

        if (savedInstanceState == null) {
            BookDetailFragment detailFragment = new BookDetailFragment();
            detailFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, detailFragment).commit();
        }

    }
}
