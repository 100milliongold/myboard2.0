import React from "react";
import styled from "@emotion/styled";
import pic01 from "../assets/images/416X256.png";

const PostSectionLayout = styled("section")`
  padding: 6em 0 4em 0;
  border-top: solid 2px rgba(210, 215, 217, 0.75);
  header {
    h2 {
      border-bottom: solid 3px #f56a6a;
      display: inline-block;
      margin: 0 0 2em 0;
      padding: 0 0.75em 0.5em 0;
    }
  }
`;

const Posts = styled("div")`
  display: -moz-flex;
  display: -webkit-flex;
  display: -ms-flex;
  display: flex;
  -moz-flex-wrap: wrap;
  -webkit-flex-wrap: wrap;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  margin: 0 0 2em -6em;
  width: calc(100% + 6em);
  article {
    -moz-flex-grow: 0;
    -webkit-flex-grow: 0;
    -ms-flex-grow: 0;
    flex-grow: 0;
    -moz-flex-shrink: 1;
    -webkit-flex-shrink: 1;
    -ms-flex-shrink: 1;
    flex-shrink: 1;
    margin: 0 0 6em 6em;
    position: relative;
    width: calc(33.33333% - 6em);
    .image {
      display: block;
      margin: 0 0 2em 0;
      img {
        display: block;
        width: 100%;
        border-radius: 0.375em;
        display: block;
      }
    }
  }
`;

export default function PostSection() {
  return (
    <PostSectionLayout>
      <header className="major">
        <h2>Ipsum sed dolor</h2>
      </header>
      <Posts className="posts">
        <article>
          <a href="#" className="image">
            <img src={pic01} alt="" />
          </a>
          <h3>Interdum aenean</h3>
          <p>
            Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore.
            Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
            tempus aliquam.
          </p>
          <ul className="actions">
            <li>
              <a href="#" className="button">
                More
              </a>
            </li>
          </ul>
        </article>
        <article>
          <a href="#" className="image">
            <img src={pic01} alt="" />
          </a>
          <h3>Nulla amet dolore</h3>
          <p>
            Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore.
            Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
            tempus aliquam.
          </p>
          <ul className="actions">
            <li>
              <a href="#" className="button">
                More
              </a>
            </li>
          </ul>
        </article>
        <article>
          <a href="#" className="image">
            <img src={pic01} alt="" />
          </a>
          <h3>Tempus ullamcorper</h3>
          <p>
            Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore.
            Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
            tempus aliquam.
          </p>
          <ul className="actions">
            <li>
              <a href="#" className="button">
                More
              </a>
            </li>
          </ul>
        </article>
        <article>
          <a href="#" className="image">
            <img src={pic01} alt="" />
          </a>
          <h3>Sed etiam facilis</h3>
          <p>
            Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore.
            Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
            tempus aliquam.
          </p>
          <ul className="actions">
            <li>
              <a href="#" className="button">
                More
              </a>
            </li>
          </ul>
        </article>
        <article>
          <a href="#" className="image">
            <img src={pic01} alt="" />
          </a>
          <h3>Feugiat lorem aenean</h3>
          <p>
            Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore.
            Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
            tempus aliquam.
          </p>
          <ul className="actions">
            <li>
              <a href="#" className="button">
                More
              </a>
            </li>
          </ul>
        </article>
        <article>
          <a href="#" className="image">
            <img src={pic01} alt="" />
          </a>
          <h3>Amet varius aliquam</h3>
          <p>
            Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore.
            Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
            tempus aliquam.
          </p>
          <ul className="actions">
            <li>
              <a href="#" className="button">
                More
              </a>
            </li>
          </ul>
        </article>
      </Posts>
    </PostSectionLayout>
  );
}
