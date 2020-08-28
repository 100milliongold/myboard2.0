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

import { css, jsx } from "@emotion/core";

const wrapper = css`
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

const main = css`
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

export const Index = () => {
  return (
    <div css={wrapper} id="wrapper">
      <div css={main} id="main">
        <div className="inner">
          <Heder />
          <BannerSection />
          <FeaturesSection />
          <PostSection />
        </div>
      </div>
      <div id="sidebar">
        <div className="inner">
          <Search />
          <SideMenu />

          <SideMiniPost />

          <SideContact />
          <SideFooter />
        </div>
      </div>
    </div>
  );
};

export default Index;
