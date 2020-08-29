import React from "react";
import styled from "@emotion/styled";

const Header = styled("header")`
  display: -moz-flex;
  display: -webkit-flex;
  display: -ms-flex;
  display: flex;
  border-bottom: solid 5px #f56a6a;
  padding: 6em 0 1em 0;
  position: relative;
`;

const Logo = styled("a")`
  border-bottom: 0;
  color: inherit;
  font-family: "Roboto Slab", serif;
  font-size: 1.125em;
  flex: 1;
  margin-bottom: 0;
`;

const Icons = styled("ul")`
  text-align: right;
`;

const List = styled("li")`
  display: inline-block;
  padding: 0 1em 0 0;
  &:last-child {
    padding-right: 0;
  }
`;

export default function HeaderLayout() {
  return (
    <Header id="header">
      <Logo href="index.html" className="logo">
        <strong>Editorial</strong> by HTML5 UP
      </Logo>
      <Icons className="icons">
        <List>
          <a href="/#" className="icon brands fa-twitter">
            <span className="label">Twitter</span>
          </a>
        </List>
        <List>
          <a href="/#" className="icon brands fa-facebook-f">
            <span className="label">Facebook</span>
          </a>
        </List>
        <List>
          <a href="/#" className="icon brands fa-snapchat-ghost">
            <span className="label">Snapchat</span>
          </a>
        </List>
        <List>
          <a href="/#" className="icon brands fa-instagram">
            <span className="label">Instagram</span>
          </a>
        </List>
        <List>
          <a href="/#" className="icon brands fa-medium-m">
            <span className="label">Medium</span>
          </a>
        </List>
      </Icons>
    </Header>
  );
}
