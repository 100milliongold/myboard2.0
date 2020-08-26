// tools/development.js

const merge = require("webpack-merge");
const config = require("./base.config");
const ErrorOverlayPlugin = require("error-overlay-webpack-plugin");
const DashboardPlugin = require("webpack-dashboard/plugin");

module.exports = merge.merge(config, {
  mode: "development",
  devtool: "cheap-eval-sourcemap",
  devServer: {
    port: 9000,
  },
  plugins: [new DashboardPlugin(), new ErrorOverlayPlugin()],
});
