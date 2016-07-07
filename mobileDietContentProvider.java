package com.example.chero.mobiledietconsultant;

/**
 * Created by Chero on 7/3/2016.
 */

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.telecom.Call;


public class mobileDietContentProvider extends ContentProvider {
    static final String PROVIDER_NAME = "com.example.chero.mobiledietconsultant";
    static final String URL = "content://" + PROVIDER_NAME + "/diet";
    static final Uri CONTENT_URI = Uri.parse(URL);
    static final String BodyType="bodytype";
static final String height=("height");
    static final String age= ("age");
    static final String gender="gender";
    static  final String weight= ("weight");
    static final UriMatcher uriMatcher;
    static int person=1;
    static int person_id=2;
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "students",person );
        uriMatcher.addURI(PROVIDER_NAME, "students/#",  person_id);

}
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "Diet";
    static final String Person_Details_Table = "Details";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE = " CREATE TABLE " + Person_Details_Table+       " " +
            "(bodytype , " +        " gender, " +       " weight ,"+ "height ," + "age);";
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
    public void onCreate( SQLiteDatabase db) {

            {           db.execSQL(CREATE_DB_TABLE);        }

    }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           db.execSQL("DROP TABLE IF EXISTS " + Person_Details_Table );
            onCreate(db);
        }}


        @Nullable
        @Override    public boolean onCreate() {
            Context context = getContext();
            DatabaseHelper dbHelper = new DatabaseHelper(context);
            db = dbHelper.getWritableDatabase();
            return (db == null)? false:true; }
        public void addDetails(){
         ContentValues values=new ContentValues(5);
            values.put("height" , 40-50);
            values.put("weight", 40-55);
            values.put("age", 15-30);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
