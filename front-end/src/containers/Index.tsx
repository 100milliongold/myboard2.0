import React from "react";
import Heder from "../components/Header";
import BannerSection from "../components/BannerSection";
import FeaturesSection from "../components/FeaturesSection";
import PostSection from "../components/PostSection";
import Search from "../components/Search";
import SideMenu from "../components/SideMenu";
import SideMiniPost from "../components/SideMiniPost";
import SideContact from "../components/SideContact";
import SideFooter from "../components/SideFooter";

import styled from "@emotion/styled";

const Wrapper = styled("div")`
  display: -moz-flex;
  display: -webkit-flex;
  display: -ms-flex;
  display: flex;
  -moz-flex-direction: row-reverse;
  -webkit-flex-direction: row-reverse;
  -ms-flex-direction: row-reverse;
  flex-direction: row-reverse;
  min-height: 100vh;
`;

const Main = styled("div")`
  -moz-flex-grow: 1;
  -webkit-flex-grow: 1;
  -ms-flex-grow: 1;
  flex-grow: 1;
  -moz-flex-shrink: 1;
  -webkit-flex-shrink: 1;
  -ms-flex-shrink: 1;
  flex-shrink: 1;
  width: 100%;
`;

const Inner = styled("div")`
  padding: 0 6em 0.1em 6em;
  margin: 0 auto;
  max-width: 110em;
`;

const SideBar = styled("div")`
  -moz-flex-grow: 0;
  -webkit-flex-grow: 0;
  -ms-flex-grow: 0;
  flex-grow: 0;
  -moz-flex-shrink: 0;
  -webkit-flex-shrink: 0;
  -ms-flex-shrink: 0;
  flex-shrink: 0;
  -moz-transition: margin-left 0.5s ease, box-shadow 0.5s ease;
  -webkit-transition: margin-left 0.5s ease, box-shadow 0.5s ease;
  -ms-transition: margin-left 0.5s ease, box-shadow 0.5s ease;
  transition: margin-left 0.5s ease, box-shadow 0.5s ease;
  background-color: #f5f6f7;
  font-size: 0.9em;
  position: relative;
  width: 26em;
`;

const SideInner = styled("div")`
  padding: 2.22222em 2.22222em 2.44444em 2.22222em;
  position: relative;
  width: 26em;
`;

const SidebarToggle = styled("a")`
  text-decoration: none;
  -moz-transition: left 0.5s ease;
  -webkit-transition: left 0.5s ease;
  -ms-transition: left 0.5s ease;
  transition: left 0.5s ease;
  -webkit-tap-highlight-color: rgba(255, 255, 255, 0);
  border: 0;
  display: block;
  height: 7.5em;
  left: 26em;
  line-height: 7.5em;
  outline: 0;
  overflow: hidden;
  position: absolute;
  text-align: center;
  text-indent: -15em;
  white-space: nowrap;
  top: 0;
  width: 6em;
  z-index: 10000;
  &:before {
    content: "\f0c9";
    font-size: 2rem;
    height: inherit;
    left: 0;
    line-height: inherit;
    position: absolute;
    text-indent: 0;
    top: 0;
    width: inherit;
  }
`;

export const Index = () => {
  return (
    <Wrapper id="wrapper">
      <Main id="main">
        <Inner className="inner">
          <Heder />
          <BannerSection />
          <FeaturesSection />
          <PostSection />
        </Inner>
      </Main>
      <SideBar id="sidebar">
        <SideInner className="inner">
          <Search />
          <SideMenu />

          <SideMiniPost />

          <SideContact />
          <SideFooter />
        </SideInner>
        <SidebarToggle href="#sidebar" className="toggle">
          Toggle
        </SidebarToggle>
      </SideBar>
    </Wrapper>
  );
};

export default Index;
