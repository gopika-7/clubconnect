package com.clubconnect;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databaseName = "SignLog.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "SignLog.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table users(email TEXT primary key, password TEXT , number TEXT primary key, name TEXT, category TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public boolean insertData(String email, String password, String name, String number, String category) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("number", number);
        contentValues.put("name", name);
        contentValues.put("category", category);
        try {
            long result = MyDatabase.insert("users", null, contentValues);
            return result != -1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            MyDatabase.close();  // Close the database to free up resources
        }
    }

    public Boolean checkEmail(String email) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();  // Use getReadableDatabase() instead of getWritableDatabase()

        try {
            Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE email = ?", new String[]{email});

            boolean emailExists = cursor.getCount() > 0;

            // Close the cursor to free up resources
            cursor.close();

            return emailExists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // Handle the exception appropriately in your application
        }
    }

    public Boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();  // Use getReadableDatabase() instead of getWritableDatabase()

        try {
            Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE email = ? AND password = ?", new String[]{email, password});

            boolean emailPasswordMatch = cursor.getCount() > 0;// Close the cursor to free up resources
            cursor.close();
            return emailPasswordMatch;
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // Handle the exception appropriately in your application
        }
    }
}