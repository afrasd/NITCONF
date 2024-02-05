// FormPage.jsx

import React from 'react';
import './form.css';  // Import the CSS file

const FormPage = () => {
  return (
    <div className="container">
      <div className="row mt-5">
        
        </div>
        
        <div className="col-8 form-container">
        <div className="col-2">
          <p>
            <a className="btn btn-outline-success btn-back" href="/dummy">
              <i className="bi bi-arrow-left-square-fill"></i> Back
            </a>
          </p>
          <h2>Review</h2>

          <form action="#" method="POST">
            <div className="form-group">
              <label htmlFor="confidence">Confidence</label>
              <input
                className="form-control"
                type="text"
                id="confidence"
                placeholder="Confidence"
              />
            </div>

            <div className="form-group">
              <label htmlFor="relevance">Relevance</label>
              <input
                className="form-control"
                type="text"
                id="relevance"
                placeholder="Relevance"
              />
            </div>

            <div className="form-group">
              <label htmlFor="originality">Originality</label>
              <input
                className="form-control"
                type="text"
                id="originality"
                placeholder="Originality"
              />
            </div>

            <div className="form-group">
              <label htmlFor="significance">Significance</label>
              <input
                className="form-control"
                type="text"
                id="significance"
                placeholder="Significance"
              />
            </div>

            <div className="form-group">
              <label htmlFor="techsound">Tech Soundness</label>
              <input
                className="form-control"
                type="text"
                id="techsound"
                placeholder="Tech Soundness"
              />
            </div>

            <div className="form-group">
              <label htmlFor="vocabulary">Vocabulary</label>
              <input
                className="form-control"
                type="text"
                id="vocabulary"
                placeholder="Vocabulary"
              />
            </div>

            <div className="form-group">
              <label htmlFor="quality">Quality</label>
              <input
                className="form-control"
                type="text"
                id="quality"
                placeholder="Quality"
              />
            </div>

            <div className="form-group">
              <label htmlFor="readability">Readability</label>
              <input
                className="form-control"
                type="text"
                id="readability"
                placeholder="Readability"
              />
            </div>

            <div className="form-group">
              <label htmlFor="commentval">Comment</label>
              <textarea
                className="form-control"
                id="commentval"
                placeholder="Comment"
                rows="5" // Make the comment box bigger by adjusting the number of rows
              ></textarea>
            </div>

            {/* Repeat similar form-group blocks for other criteria */}

            <button type="submit" className="btn btn-outline-success btn-submit">
              <i className="bi bi-plus-square-fill"></i> Add To Review
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default FormPage;
