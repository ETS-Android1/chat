package com.example.chatfull;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Base64;

import androidx.annotation.Nullable;

import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;
import com.stfalcon.chatkit.commons.models.MessageContentType;

import java.io.Serializable;
import java.util.Date;

public class Message implements IMessage, Serializable, MessageContentType.Image {

    private String id, text;
    private User user;
    private Date createdAt;

    private String filename;
    private byte[] file;

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private boolean isImage;

    public Message(String id, User user, String text) {
        this(id, user, text, new Date());
    }

    public Message(String id, User user, String text, Date createdAt) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.createdAt = createdAt;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        if(filename != null) return filename;
        else return id;
    }

    public void setText(String text) { this.text = text; }

    public void setUser(User user) { this.user = user; }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setIsImage(boolean image) {
        isImage = image;
    }

    @Nullable
    @Override
    public String getImageUrl() {
        if(isImage == false) return null;
        else{
            return Base64.encodeToString(file,Base64.DEFAULT);
        }
    }
}