package mirea.buryakov.mymovies.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Movie.class, FavouriteMovie.class}, version = 2, exportSchema = false)
public abstract class MovieDatabase  extends RoomDatabase {

    private static MovieDatabase database;
    private static final String DB_NAME = "movies.db";
    private static final Object MONITOR = new Object();

    public static MovieDatabase getInstance(Context context) {
        synchronized (MONITOR) {
            if (database == null) {
                database = Room.databaseBuilder(context,MovieDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
            }
        }
        return database;
    }

    public abstract MovieDAO movieDAO();
}