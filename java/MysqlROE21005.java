package com.example.lprincesssbloglimengjueroe21005;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MysqlROE21005 extends SQLiteOpenHelper {
    public MysqlROE21005(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase dblimengjue) {
        String createLoginsTablelimengjue = "CREATE TABLE logins(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,userpwd TEXT)";
        String createLikesTablelimengjue = "CREATE TABLE likes (id INTEGER PRIMARY KEY AUTOINCREMENT,item_id INTEGER,likes INTEGER Default 0)";
        String createCommentsTable1limengjue = "CREATE TABLE comments1 (id INTEGER PRIMARY KEY AUTOINCREMENT,item_id INTEGER,comment text)";
        String createCommentsTable2limengjue = "CREATE TABLE comments2 (id INTEGER PRIMARY KEY AUTOINCREMENT,item_id INTEGER,comment text)";
        String createCommentsTable3limengjue = "CREATE TABLE comments3 (id INTEGER PRIMARY KEY AUTOINCREMENT,item_id INTEGER,comment text)";
        String createSuggestionTablelimengjue = "CREATE TABLE suggestion (id INTEGER PRIMARY KEY AUTOINCREMENT, suggestion text,contactInfo text)";

        dblimengjue.execSQL(createLoginsTablelimengjue);
        dblimengjue.execSQL(createLikesTablelimengjue);
        dblimengjue.execSQL(createCommentsTable1limengjue);
        dblimengjue.execSQL(createCommentsTable2limengjue);
        dblimengjue.execSQL(createCommentsTable3limengjue);
        dblimengjue.execSQL(createSuggestionTablelimengjue);

        for(int i=1;i<=3;i++){
            ContentValues valueslimengjue = new ContentValues();
            valueslimengjue.put("item_id",i);
            valueslimengjue.put("likes",0);
            dblimengjue.insert("likes",null,valueslimengjue);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS logins");
        db.execSQL("DROP TABLE IF EXISTS likes");
        db.execSQL("DROP TABLE IF EXISTS comments1");
        db.execSQL("DROP TABLE IF EXISTS comments2");
        db.execSQL("DROP TABLE IF EXISTS comments3");
        db.execSQL("DROP TABLE IF EXISTS suggestion");

        onCreate(db);
    }


    public void addLike(int itemId){
        SQLiteDatabase dblimengjue = this.getWritableDatabase();
        Cursor cursorlimengjue = null;
        try{
            cursorlimengjue = dblimengjue.rawQuery("SELECT likes FROM likes WHERE item_id = ?",new String[]{String.valueOf(itemId)});

            if(cursorlimengjue !=null && cursorlimengjue.moveToFirst()){
                @SuppressLint("Range") int currentLikeslimengjue = cursorlimengjue.getInt(cursorlimengjue.getColumnIndex("likes"));
                ContentValues valueslimengjue = new ContentValues();
                valueslimengjue.put("likes",currentLikeslimengjue+1);
                dblimengjue.update("likes",valueslimengjue,"item_id=?",new String[]{String.valueOf(itemId)});
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursorlimengjue != null){
                // cursor.close();
            }
            // db.close();
        }
    }


    public  void addComment(int itemIdlimengjue,String commentlimengjue){
        SQLiteDatabase dblimengjue = this.getWritableDatabase();
        ContentValues valueslimengjue = new ContentValues();
        valueslimengjue.put("item_id", itemIdlimengjue);
        valueslimengjue.put("comment", commentlimengjue);
        if(itemIdlimengjue==1){
            dblimengjue.insert("comments1", null, valueslimengjue);
        }
        else if(itemIdlimengjue == 2){
            dblimengjue.insert("comments2", null, valueslimengjue);
        }
        else if(itemIdlimengjue == 3){
            dblimengjue.insert("comments3", null, valueslimengjue);
        }

    }

    public void addSuggestion(String suggestion,String contactInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("suggestion",suggestion);
        values.put("contactInfo",contactInfo);
        db.insert("suggestion",null,values);
    }

    public Cursor getComments(int itemId){
        SQLiteDatabase db = this.getReadableDatabase();
        if(itemId==1){
            return db.rawQuery("SELECT * FROM comments1 WHERE item_id = ?",new String[]{String.valueOf(itemId)});
        }
        else if(itemId == 2){
            return db.rawQuery("SELECT * FROM comments2 WHERE item_id = ?",new String[]{String.valueOf(itemId)});
        }
        else{
            return db.rawQuery("SELECT * FROM comments3 WHERE item_id = ?",new String[]{String.valueOf(itemId)});
        }
    }

    @SuppressLint("Range")
    public int getallLikes(int itemId){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int count = 0;
        try{
            cursor = db.rawQuery("SELECT likes FROM likes WHERE item_id = ?",new String[]{String.valueOf(itemId)});
            if(cursor != null && cursor.moveToFirst()){
                count = cursor.getInt(cursor.getColumnIndex("likes"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(cursor != null){
                cursor.close();
            }
        }
        return count;
    }

    public int getallComments(int itemId){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int count = 0;
        try{
            String tableName = "comments"+itemId;
            cursor = db.rawQuery("SELECT COUNT(*) FROM "+tableName,null);
            if(cursor!=null&& cursor.moveToFirst()){
                count = cursor.getInt(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null){
                cursor.close();
            }
        }
        return count;
    }
}
