/**
 * Copyright © 2011 PolySpot 
 */
package com.polyspot.iw.indexer;

import com.polyspot.iw.business.database.IDatabaseDriver;
import com.polyspot.iw.business.model.ChangeSet;
import com.polyspot.iw.business.model.Document;
import com.polyspot.iw.indexer.server.IndexerService;
import org.mockito.Mockito;

import javax.servlet.ServletContext;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created on 09/09/11 08:30)
 *
 * @author nono
 */
public class WhenGettingChangedDocuments {

  private int since;
  private String type;
  private int maximumSize;

  private int numberRetrieved;
  private IndexerService service;
  private IDatabaseDriver driver;
  private Set<Document> store;

  public WhenGettingChangedDocuments() {
    this.driver = mock(IDatabaseDriver.class);
    ServletContext context = mock(ServletContext.class);
    when(context.getAttribute("com.polyspot.iw.dbDriver")).thenReturn(driver);
    this.service=  new IndexerService(context);
    this.store = GivenDocumentsDatabaseContainsAtTime.database();
  }

  public void setSince(int since) {
    this.since = since;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setMaximumSize(int maximumSize) {
    this.maximumSize = maximumSize;
  }

  public int numberRetrieved() {
    return numberRetrieved;
  }

  public void execute() {
    when(driver.getChangedDocument(String.valueOf(since),maximumSize,null,type,null)).thenReturn(new ChangeSet(store, null, 0));
    numberRetrieved = service.getChangedDocument(String.valueOf(since), maximumSize, null, type, null).getUpdate().size();
  }
}
