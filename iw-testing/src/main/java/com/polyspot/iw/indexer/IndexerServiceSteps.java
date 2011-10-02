package com.polyspot.iw.indexer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.polyspot.iw.business.database.IDatabaseDriver;
import com.polyspot.iw.business.model.ChangeSet;
import com.polyspot.iw.business.model.Document;
import com.polyspot.iw.indexer.server.IndexerService;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import org.junit.Assert;

/**
 * Created on 16/09/11 09:47)
 * 
 * @author nono
 */
public class IndexerServiceSteps {
  
  public static class DocumentInfo {
    public String uri;
    public int createdTime;
    public String infoType;
    
    public Document asDocument() {
      Document currentDocument = new Document();
      currentDocument.setUri(uri);
      currentDocument.setCreatedTime(new Date(createdTime));
      currentDocument.setInfoType(infoType);
      return currentDocument;
    }
  }
  
  private static Set<Document> store = new HashSet<Document>();
  private IndexerService service;
  private IDatabaseDriver driver;
  private int numberRetrieved;
  
  @Given("^documents database contains:$")
  public void documentsDatabaseContains(List<DocumentInfo> documents) {
    for (DocumentInfo documentInfo : documents) {
      store.add(documentInfo.asDocument());
    }
  }
  
  @When("^getting changed since time (\\d)$")
  public void gettingSinceTime(int since) {
    this.driver = mock(IDatabaseDriver.class);
    ServletContext context = mock(ServletContext.class);
    when(context.getAttribute("com.polyspot.iw.dbDriver")).thenReturn(driver);
    this.service = new IndexerService(context);
    
    when(driver.getChangedDocument(String.valueOf(since), 0, null, null, null))
        .thenReturn(new ChangeSet(store, null, 0));
    numberRetrieved = service
        .getChangedDocument(String.valueOf(since), 0, null, null, null)
        .getUpdate().size();
  }
  
  @Then("^I retrieve (\\d+) documents$")
  public void retrieveDocuments(int expectedNumberRetrieved) {
    Assert.assertEquals(this.numberRetrieved, expectedNumberRetrieved);
  }
  
}
