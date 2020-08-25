// tools/development.js

const merge = require("webpack-merge");
const config = require("./base.config");

module.exports = merge.merge(config, {
  mode: "development",
  devtool: "cheap-eval-sourcemap",
  devServer: {
    port: 9000,
  },
});
