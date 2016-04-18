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

package com.ibm.watson.developer_cloud.professor_languo.exception;

import com.ibm.watson.developer_cloud.professor_languo.api.AnswerScorer;

/**
 * An {@link Exception} that is thrown during the {@link AnswerScorer} component of a pipeline
 *
 */
public class AnswerScorerException extends PipelineException {

  private static final long serialVersionUID = 327021470033328723L;

  /**
   * Create a new {@link AnswerScorerException} with a given message
   * 
   * @param msg - The exception message
   */
  public AnswerScorerException(String msg) {
    super(msg);
  }

  /**
   * Create a new {@link AnswerScorerException} with a given cause
   * 
   * @param cause - The {@link Throwable} cause of the exception
   */
  public AnswerScorerException(Throwable cause) {
    super(cause);
  }

}
