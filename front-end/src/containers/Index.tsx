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

export const Index = () => {
  return (
    <>
      <div id="main">
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
    </>
  );
};

export default Index;
