package com.example.eartrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TheoryActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        setUp();
    }

    void setUp()
    {
        // TODO: Do less hardcoding here, perhaps by defining chord intervals and such elsewhere
        // Unison

        findViewById(R.id.btn_interval_0a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_0d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_0h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 60, 0);
            }
        });

        // Minor second

        findViewById(R.id.btn_interval_1a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 61, 1000);
            }
        });
        findViewById(R.id.btn_interval_1d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 61, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_1h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 61, 0);
            }
        });

        // Major second

        findViewById(R.id.btn_interval_2a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 62, 1000);
            }
        });
        findViewById(R.id.btn_interval_2d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 62, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_2h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 62, 0);
            }
        });

        // Minor third

        findViewById(R.id.btn_interval_3a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 63, 1000);
            }
        });
        findViewById(R.id.btn_interval_3d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 63, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_3h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 63, 0);
            }
        });

        // Major third

        findViewById(R.id.btn_interval_4a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 64, 1000);
            }
        });
        findViewById(R.id.btn_interval_4d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 64, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_4h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 64, 0);
            }
        });

        // Perfect fourth

        findViewById(R.id.btn_interval_5a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 65, 1000);
            }
        });
        findViewById(R.id.btn_interval_5d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 65, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_5h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 65, 0);
            }
        });

        // Augmented fourth / Diminished fifth

        findViewById(R.id.btn_interval_6a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 66, 1000);
            }
        });
        findViewById(R.id.btn_interval_6d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 66, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_6h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 66, 0);
            }
        });

        // Perfect fifth

        findViewById(R.id.btn_interval_7a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 67, 1000);
            }
        });
        findViewById(R.id.btn_interval_7d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 67, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_7h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 67, 0);
            }
        });

        // Minor sixth

        findViewById(R.id.btn_interval_8a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 68, 1000);
            }
        });
        findViewById(R.id.btn_interval_8d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 68, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_8h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 68, 0);
            }
        });

        // Major sixth

        findViewById(R.id.btn_interval_9a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 69 /* nice */, 1000);
            }
        });
        findViewById(R.id.btn_interval_9d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 69, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_9h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 69, 0);
            }
        });

        // Minor seventh

        findViewById(R.id.btn_interval_10a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 70, 1000);
            }
        });
        findViewById(R.id.btn_interval_10d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 70, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_10h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 70, 0);
            }
        });

        // Major seventh

        findViewById(R.id.btn_interval_11a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 71, 1000);
            }
        });
        findViewById(R.id.btn_interval_11d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 71, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_11h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 71, 0);
            }
        });

        // Octave

        findViewById(R.id.btn_interval_12a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 72, 1000);
            }
        });
        findViewById(R.id.btn_interval_12d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 72, 60, 1000);
            }
        });
        findViewById(R.id.btn_interval_12h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new SoundManager().playInterval(getApplicationContext(), 60, 72, 0);
            }
        });

        // Major

        findViewById(R.id.btn_chord_maj_a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 64, 67 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_maj_d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 67, 64, 60 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_maj_h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 64, 67 };
                new SoundManager().playChord(getApplicationContext(), notes, 0);
            }
        });

        // Minor

        findViewById(R.id.btn_chord_min_a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 63, 67 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_min_d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 67, 63, 60 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_min_h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 63, 67 };
                new SoundManager().playChord(getApplicationContext(), notes, 0);
            }
        });

        // Diminished

        findViewById(R.id.btn_chord_dim_a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 63, 66 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_dim_d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 66, 63, 60 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_dim_h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 63, 66 };
                new SoundManager().playChord(getApplicationContext(), notes, 0);
            }
        });

        // Augmented

        findViewById(R.id.btn_chord_aug_a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 64, 68 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_aug_d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 68, 64, 60 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_aug_h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 64, 68 };
                new SoundManager().playChord(getApplicationContext(), notes, 0);
            }
        });

        // Dominant seventh

        findViewById(R.id.btn_chord_7_a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 64, 67, 70 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_7_d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 70, 67, 64, 60 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_7_h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 64, 67, 70 };
                new SoundManager().playChord(getApplicationContext(), notes, 0);
            }
        });

        // Minor seventh

        findViewById(R.id.btn_chord_min7_a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 63, 67, 70 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_min7_d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 70, 67, 63, 60 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_min7_h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 63, 67, 70 };
                new SoundManager().playChord(getApplicationContext(), notes, 0);
            }
        });

        // Major seventh

        findViewById(R.id.btn_chord_maj7_a).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 64, 67, 71 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_maj7_d).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 71, 67, 64, 60 };
                new SoundManager().playChord(getApplicationContext(), notes, 1000);
            }
        });
        findViewById(R.id.btn_chord_maj7_h).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int[] notes = { 60, 64, 67, 71 };
                new SoundManager().playChord(getApplicationContext(), notes, 0);
            }
        });
    }
}
