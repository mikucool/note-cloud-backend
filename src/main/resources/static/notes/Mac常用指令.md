# Mac 常用指令

- 删除文件夹

~~~shell
rm -rf xxx
~~~











# Homebrew 常用命令

```shell
brew install name         # 安装源码
brew info svn                # 显示软件的各种信息（包括版本、源码地址、依赖等等）
brew uninstall name     # 卸载软件
brew search name       # 搜索brew 支持的软件（支持模糊搜索）
brew list                       # 列出本机通过brew安装的所有软件
brew update                # brew自身更新
brew upgrade name    #更新安装过的软件(如果不加软件名，就更新所有可以更新的软件)
brew cleanup             #清除下载的缓存
```

```shell
brew cask search               # 列出所有可以被安装的软件
brew cask search name     # 查找所有和 name相关的应用
brew cask install name       # 下载安装软件
brew cask uninstall name   # 卸载软件
brew cask info app             # 列出应用的信息
brew cask list                      # 列出本机安装过的软件列表
brew cask cleanup              # 清除下载的缓存以及各种链接信息
brew cask uninstall name && brew cask install name ＃更新程序 （目前homebrew-cask 并没有命令直接更新已安装的软件，软件更新主要是通过软件自身的完成更新）
```
