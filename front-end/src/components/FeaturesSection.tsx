import React from "react";

import styled from "@emotion/styled";

const Section = styled("section")`
  padding: 6em 0 4em 0;
  border-top: solid 2px rgba(210, 215, 217, 0.75);
`;
const Major = styled("header")`
  display: block;
  &: first-child {
    border-bottom: solid 3px #f56a6a;
    display: inline-block;
    margin: 0 0 2em 0;
    padding: 0 0.75em 0.5em 0;
  }
`;
const Feature = styled("div")`
  display: -moz-flex;
  display: -webkit-flex;
  display: -ms-flex;
  display: flex;
  -moz-flex-wrap: wrap;
  -webkit-flex-wrap: wrap;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  margin: 0 0 2em -3em;
  width: calc(100% + 3em);
  article {
    -moz-align-items: center;
    -webkit-align-items: center;
    -ms-align-items: center;
    align-items: center;
    display: -moz-flex;
    display: -webkit-flex;
    display: -ms-flex;
    display: flex;
    margin: 0 0 3em 3em;
    position: relative;
    width: calc(50% - 3em);
    & :nth-child(2n - 1) {
      margin-right: 1.5em;
    }
    .icon {
      text-decoration: none;
      border-bottom: none;
      position: relative;
      -moz-flex-grow: 0;
      -webkit-flex-grow: 0;
      -ms-flex-grow: 0;
      flex-grow: 0;
      -moz-flex-shrink: 0;
      -webkit-flex-shrink: 0;
      -ms-flex-shrink: 0;
      flex-shrink: 0;
      display: block;
      height: 10em;
      line-height: 10em;
      margin: 0 2em 0 0;
      text-align: center;
      width: 10em;
      &: before {
        color: #f56a6a;
        font-size: 2.75rem;
        position: relative;
        top: 0.05em;
      }
      &: after {
        -moz-transform: rotate(45deg);
        -webkit-transform: rotate(45deg);
        -ms-transform: rotate(45deg);
        transform: rotate(45deg);
        border-radius: 0.25rem;
        border: solid 2px rgba(210, 215, 217, 0.75);
        content: "";
        display: block;
        height: 7em;
        left: 50%;
        margin: -3.5em 0 0 -3.5em;
        position: absolute;
        top: 50%;
        width: 7em;
      }
    }
  }
`;

export default function Features() {
  return (
    <Section>
      <Major className="major">
        <h2>Erat lacinia</h2>
      </Major>
      <Feature className="features">
        <article>
          <span className="icon fa-gem"></span>
          <div className="content">
            <h3>Portitor ullamcorper</h3>
            <p>
              Aenean ornare velit lacus, ac varius enim lorem ullamcorper
              dolore. Proin aliquam facilisis ante interdum. Sed nulla amet
              lorem feugiat tempus aliquam.
            </p>
          </div>
        </article>
        <article>
          <span className="icon solid fa-paper-plane"></span>
          <div className="content">
            <h3>Sapien veroeros</h3>
            <p>
              Aenean ornare velit lacus, ac varius enim lorem ullamcorper
              dolore. Proin aliquam facilisis ante interdum. Sed nulla amet
              lorem feugiat tempus aliquam.
            </p>
          </div>
        </article>
        <article>
          <span className="icon solid fa-rocket"></span>
          <div className="content">
            <h3>Quam lorem ipsum</h3>
            <p>
              Aenean ornare velit lacus, ac varius enim lorem ullamcorper
              dolore. Proin aliquam facilisis ante interdum. Sed nulla amet
              lorem feugiat tempus aliquam.
            </p>
          </div>
        </article>
        <article>
          <span className="icon solid fa-signal"></span>
          <div className="content">
            <h3>Sed magna finibus</h3>
            <p>
              Aenean ornare velit lacus, ac varius enim lorem ullamcorper
              dolore. Proin aliquam facilisis ante interdum. Sed nulla amet
              lorem feugiat tempus aliquam.
            </p>
          </div>
        </article>
      </Feature>
    </Section>
  );
}
