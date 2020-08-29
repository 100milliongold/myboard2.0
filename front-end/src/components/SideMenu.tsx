import React from "react";
import styled from "@emotion/styled";

const Menu = styled("nav")`
  border-bottom: solid 2px rgba(210, 215, 217, 0.75);
  margin: 0 0 3.5em 0;
  padding: 0 0 3.5em 0;
  ul {
    -moz-user-select: none;
    -webkit-user-select: none;
    -ms-user-select: none;
    user-select: none;
    color: #3d4449;
    font-family: "Roboto Slab", serif;
    font-weight: 400;
    letter-spacing: 0.075em;
    list-style: none;
    margin-bottom: 0;
    padding: 0;
    text-transform: uppercase;
    li {
      border-top: solid 1px rgba(210, 215, 217, 0.75);
      margin: 0.5em 0 0 0;
      padding: 0.5em 0 0 0;
      & :first-child {
        border-top: 0;
        margin-top: 0;
        padding-top: 0;
      }
      a, span : {
        border-bottom: 0;
        color: inherit;
        cursor: pointer;
        display: block;
        font-size: 0.9em;
        padding: 0.625em 0;
      }
    }
  }
`;
const Major = styled("header")`
  display: block;
  h2 {
    border-bottom: solid 3px #f56a6a;
    display: inline-block;
    margin: 0 0 2em 0;
    padding: 0 0.75em 0.5em 0;
  }
`;

export default function SideMenu() {
  return (
    <Menu id="menu">
      <Major className="major">
        <h2>Menu</h2>
      </Major>
      <ul>
        <li>
          <a href="index.html">Homepage</a>
        </li>
        <li>
          <a href="generic.html">Generic</a>
        </li>
        <li>
          <a href="elements.html">Elements</a>
        </li>
        <li>
          <span className="opener">Submenu</span>
          <ul>
            <li>
              <a href="#">Lorem Dolor</a>
            </li>
            <li>
              <a href="#">Ipsum Adipiscing</a>
            </li>
            <li>
              <a href="#">Tempus Magna</a>
            </li>
            <li>
              <a href="#">Feugiat Veroeros</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">Etiam Dolore</a>
        </li>
        <li>
          <a href="#">Adipiscing</a>
        </li>
        <li>
          <span className="opener">Another Submenu</span>
          <ul>
            <li>
              <a href="#">Lorem Dolor</a>
            </li>
            <li>
              <a href="#">Ipsum Adipiscing</a>
            </li>
            <li>
              <a href="#">Tempus Magna</a>
            </li>
            <li>
              <a href="#">Feugiat Veroeros</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">Maximus Erat</a>
        </li>
        <li>
          <a href="#">Sapien Mauris</a>
        </li>
        <li>
          <a href="#">Amet Lacinia</a>
        </li>
      </ul>
    </Menu>
  );
}
