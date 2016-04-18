/*
 * Copyright IBM Corp. 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.professor_languo.primary_search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.junit.Test;

import static org.junit.Assert.*;

import com.ibm.watson.developer_cloud.professor_languo.data_model.Question;
import com.ibm.watson.developer_cloud.professor_languo.exception.SearchException;
import com.ibm.watson.developer_cloud.professor_languo.model.stack_exchange.StackExchangeQuestion;
import com.ibm.watson.developer_cloud.professor_languo.pipeline.primary_search.AnalyzerUtils;
import com.ibm.watson.developer_cloud.professor_languo.pipeline.primary_search.NgramAnalyzer;
import com.ibm.watson.developer_cloud.professor_languo.pipeline.primary_search.PrimarySearchConstants;
import com.ibm.watson.developer_cloud.professor_languo.pipeline.primary_search.QueryComponentFactory;

public class NaiveBigramQueryGeneratorObsolete {

  NaiveBigramQueryGeneratorObsolete GIVEN = this, AND = this, WHEN = this, THEN = this;

  private Question queryQuestion = null;
  private Query naiveBigramQuery = null;

  private final String question = "The quick brown fox jumped over the lazy dogs";

  @Test public void test_bigram_query_is_generated_correctly() throws IOException, SearchException {
    GIVEN.query_question_is_built();
    WHEN.bigram_query_is_generated();
    THEN.test_that_generated_bigram_query_match_the_referenced_query();
  }

  private void bigram_query_is_generated() throws SearchException {
    if (naiveBigramQuery == null) {
      naiveBigramQuery = QueryComponentFactory
          .generateQueryComponent(PrimarySearchConstants.NAIVE_BIGRAM_QUERY_GENERATOR).generateQuery(queryQuestion);
    }
  }

  private void test_that_generated_bigram_query_match_the_referenced_query() throws IOException {
    Set<Term> queryTerms = new HashSet<Term>();
    naiveBigramQuery.extractTerms(queryTerms);
    List<String> genTermsText = new ArrayList<String>();
    for (Term term : queryTerms)
      genTermsText.add(term.text());
    List<String> referTermsText = AnalyzerUtils.collectTokens(new NgramAnalyzer(2), question);
    for (String token : genTermsText)
      assertTrue(referTermsText.contains(token));
    for (String token : referTermsText)
      assertTrue(genTermsText.contains(token));
  }

  private void query_question_is_built() {
    if (queryQuestion == null)
      queryQuestion = new StackExchangeQuestion(question, "", null, 1, "");
  }
}
