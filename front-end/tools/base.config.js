// tools/base.js
const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const DashboardPlugin = require("webpack-dashboard/plugin");

module.exports = {
  entry: {
    vendor: ["react", "react-dom"],
    app: path.resolve(__dirname, "..", "src", "App.tsx"),
  },
  optimization: {
    splitChunks: {
      cacheGroups: {
        vendor: {
          chunks: "initial",
          name: "vendor",
          enforce: true,
        },
      },
    },
  },
  output: {
    filename: "[name].[chunkhash].js",
    chunkFilename: "[name].[chunkhash].chunk.js",
  },
  resolve: {
    extensions: [".js", ".ts", ".tsx"],
    alias: {
      components: path.resolve(__dirname, "..", "src", "components"),
      containers: path.resolve(__dirname, "..", "src", "containers"),
      assets: path.resolve(__dirname, "..", "src", "assets"),
    },
  },
  module: {
    rules: [
      {
        test: /\.(ts|tsx)$/,
        exclude: /node_modules/,
        use: [
          {
            loader: "ts-loader",
          },
        ],
      },
    ],
  },
  // plugins
  plugins: [
    new HtmlWebpackPlugin({
      template: "./public/index.html",
      filename: "./index.html",
    }),
    new DashboardPlugin(),
  ],
};
