App({
  globalData: {
    isIphoneX: false,
    userInfo: null,
    urlPath: "http://localhost:8086/translation",
    about: '此项目长期维护，如果有需要的可以在github自行下载，感觉还不错可以给作者star',
    openid: undefined,
    unionid: undefined,
    session_key: undefined,
    flag: undefined,
    sessionid:undefined,
    code:undefined,
  },
  onShow: function() {
    let that = this;
    wx.getSystemInfo({
      success: res => {
        // console.log('手机信息res'+res.model)
        let modelmes = res.model;
        if (modelmes.search('iPhone X') != -1) {
          that.globalData.isIphoneX = true
        }

      }
    })
  },
  onLaunch: function() {
    // 展示本地存储能力
    var that = this
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    // 登录
    wx.login({
      success: function(res) {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if (res.code) {
          that.globalData.code = res.code;
          wx.request({
            url: that.globalData.urlPath + '/WxInfo/getopenid',
            data: {
              code: res.code
            },
            method: 'POST',
            header: {
              'content-type': 'application/json'
            },
            success: function (res) {
              console.log(res.data.WxInfo.sessionId)
              that.globalData.openid = res.data.WxInfo.openId
              that.globalData.sessionid = res.data.WxInfo.sessionId
            },
            fail: function(err){
              wx.showModal({
                content: '连接小程序失败，请检查您的网络状况',
                showCancel: false,
                success: function (res) {
                  if (res.confirm) {
                    wx.request({
                      url: that.globalData.urlPath + '/WxInfo/getopenid',
                      data: {
                        code: that.globalData.code
                      },
                      method: 'POST',
                      header: {
                        'content-type': 'application/json'
                      },
                      success: function (res) {
                        console.log(res.data.WxInfo.sessionId)
                        that.globalData.openid = res.data.WxInfo.openId
                        that.globalData.sessionid = res.data.WxInfo.sessionId
                      },
                      fail: function(err){
                        that.onLaunch()
                      }
                    })
                  }
                }
              });
            }
          })
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
    // 获取用户信息
    // wx.getSetting({
    //   success: res => {
    //     if (res.authSetting['scope.userInfo']) {
    //       // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
    //       wx.getUserInfo({
    //         success: res => {
    //           // 可以将 res 发送给后台解码出 unionId
    //           that.globalData.userInfo = res.userInfo
    //           console.log(res.encryptedData)
    //           // console.log(that.globalData.openid)
    //           // console.log(res.userInfo);
    //           // console.log(that.globalData.unionid);
    //           // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
    //           // 所以此处加入 callback 以防止这种情况
    //           if (that.userInfoReadyCallback) {
    //             that.userInfoReadyCallback(res)
    //           }
    //         }
    //       })
    //     } else {
    //       // wx.reLaunch({
    //       //   url: '/pages/translation/index',
    //       // })
    //     }
    //   }
    // })
  }
});