/**
 * Copyright © 2011 PolySpot 
 */
package com.polyspot.iw.indexer;

import com.polyspot.iw.business.model.Content;
import com.polyspot.iw.business.model.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nono
 */
public class GivenDocumentsDatabaseContainsAtTime {

  private final int time;
  private Document currentDocument;
  private static Set<Document> store = new HashSet<Document>();

  public GivenDocumentsDatabaseContainsAtTime(int time) {
    this.time = time;
    this.currentDocument = new Document();
  }

  public void setUrl(String url) {
    currentDocument.setUri(url);
  }

  public void setWhenChanged(int time) {
    currentDocument.setCreatedTime(new Date(time));
  }

  public void setSize(int size) {
  }

  public void setType(String type) {
    currentDocument.setInfoType(type);
  }

  public void execute() {
    store.add(currentDocument);
    currentDocument = new Document();
  }

  public static Set<Document> database() {
    return store;
  }
}
