package com.a5.ngenemichael.quotes;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Random;

public class MyWidgetProvider extends AppWidgetProvider {

    Random r ; int v;
    String [] greatness = {"\" Be not afraid of greatness. Some are born great, some achieve greatness, and others have greatness thrust upon them.\" -William Shakespeare, Twelfth Night",
            "”Great spirits have always encountered violent opposition from mediocre minds.-”Albert Einstein",
            "“Simplicity is the keynote of all true elegance.”- Coco Chanel",
            "“Don't blow off another's candle for it won't make yours shine brighter.” -Jaachynma N.E. Agu, The Prince and the Pauper ",
            "“I was never afraid of failure; for I would sooner fail than not be among the greatest.” -  John Keats",
            "“Nothing is more simple than greatness; indeed, to be simple is to be great.”- Ralph Waldo Emerson",
            "“Don't set your goals by what other people deem important.”- Jaachynma N.E. Agu, The Prince and the Pauper ",
            "“The greatness of humanity is not in being human, but in being humane.”- Mahatma Gandhi",
            "“The final proof of greatness lies in being able to endure criticism without resentment.”- Elbert Hubbard",
            "“Your greatness is revealed not by the lights that shine upon you, but by the light that shines within you.”- Ray A. Davis",
            "“When you're good at something, you'll tell everyone. When you're great at something, they'll tell you.”- Walter Payton",
            "“The past is to be respected and acknowledged, but not worshipped; it is our future in which we will find our greatness.”- Pierre Trudeau",
            "“Maybe if we stopped trying to achieve movie standards of greatness, we'd be happy -Amber L. Johnson, Puddle Jumping ",
           /* "",
            "",
            "",
            "",
            "",*/
    };
    AllQuotes mAllQuotes = new AllQuotes();
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int i = 0; i <appWidgetIds.length ; i++) {

            r = new Random();
            v = r.nextInt(mAllQuotes.names.length);
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
            String text = mAllQuotes.greatness[v];
            String namz = mAllQuotes.names[v];
            views.setTextViewText(R.id.text,text);
            views.setTextViewText(R.id.nax,namz);

            Intent openApp = new Intent(context,MainActivity.class);
            PendingIntent pintent = PendingIntent.getActivity(context,0,openApp,0);
            views.setOnClickPendingIntent(R.id.imageView,pintent);

            Intent refresh = new Intent(context,MyWidgetProvider.class);
            refresh.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            refresh.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetIds);
            PendingIntent pint = PendingIntent.getBroadcast(context,0,refresh,PendingIntent.FLAG_UPDATE_CURRENT);
            //views.setOnClickPendingIntent(R.id.imageView,pint);

            appWidgetManager.updateAppWidget(appWidgetIds[i],views);
        }
    }
}
