import React from "react";

import styled from "@emotion/styled";

const Banner = styled("section")`
  border-top: 0 !important;
  padding: 6em 0 4em 0;
  display: flex;
`;

const Actions = styled("ul")`
  display: -moz-flex;
  display: -webkit-flex;
  display: -ms-flex;
  display: flex;
  cursor: default;
  list-style: none;
  margin-left: -1em;
  padding-left: 0;
  li {
    padding: 0 0 0 1em;
    vertical-align: middle;
  }
`;

const Button = styled("a")`
  -moz-appearance: none;
  -webkit-appearance: none;
  -ms-appearance: none;
  appearance: none;
  -moz-transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
  -webkit-transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
  -ms-transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
  transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
  background-color: transparent;
  border-radius: 0.375em;
  border: 0;
  box-shadow: inset 0 0 0 2px #f56a6a;
  color: #f56a6a !important;
  cursor: pointer;
  display: inline-block;
  font-family: "Roboto Slab", serif;
  font-size: 0.8em;
  font-weight: 700;
  height: 3.5em;
  letter-spacing: 0.075em;
  line-height: 3.5em;
  padding: 0 2.25em;
  text-align: center;
  text-decoration: none;
  text-transform: uppercase;
  white-space: nowrap;
`;

export default function BannerSection() {
  return (
    <Banner id="banner">
      <div className="content">
        <header>
          <h1>
            Hi, I’m Editorial
            <br />
            by HTML5 UP
          </h1>
          <p>A free and fully responsive site template</p>
        </header>
        <p>
          Aenean ornare velit lacus, ac varius enim ullamcorper eu. Proin
          aliquam facilisis ante interdum congue. Integer mollis, nisl amet
          convallis, porttitor magna ullamcorper, amet egestas mauris. Ut magna
          finibus nisi nec lacinia. Nam maximus erat id euismod egestas.
          Pellentesque sapien ac quam. Lorem ipsum dolor sit nullam.
        </p>
        <Actions className="actions">
          <li>
            <Button href="#" className="button big">
              Learn More
            </Button>
          </li>
        </Actions>
      </div>
      <span className="image object">
        <img
          src="https://html5up.net/uploads/demos/editorial/images/pic10.jpg"
          alt=""
        />
      </span>
    </Banner>
  );
}
