package com.jaredrummler.fontreader.truetype;

import com.jaredrummler.fontreader.fonts.FontUtil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FontInfo {
    protected String postScriptName = "";
    protected final Set<String> familyNames = new HashSet<String>();
    protected String subFamilyName = "";
    protected String fullName = "";
    protected String notice = "";

    FontInfo(String postScriptName,
             Set<String> familyNames,
             String subFamilyName,
             String fullName,
             String notice) {
        this.postScriptName = postScriptName;
        this.familyNames.addAll(familyNames);
        this.subFamilyName = subFamilyName;
        this.fullName = fullName;
        this.notice = notice;
    }

    public String getPostScriptName() {
        return this.postScriptName.length() == 0 ? FontUtil.stripWhiteSpace(this.getFullName()) : this.postScriptName;
    }

    public Set<String> getFamilyNames() {
        return this.familyNames;
    }

    public String getSubFamilyName() {
        return this.subFamilyName;
    }

    public String getFullName() {
        return this.fullName;
    }
    public String getCopyrightNotice() {
        return this.notice;
    }
}
