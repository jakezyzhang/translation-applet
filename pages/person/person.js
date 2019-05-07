// pages/person/person.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    active: 0,
    nickName: '微信授权登录',
    avatarUrl: '../../package/icons/head.png',
    flag: undefined
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    that.setData({
      active: options.active
    })
    that.queryWxUserInfo();
    wx.getSetting({
      success(res) {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          wx.getUserInfo({
            success(res) {
              console.log(res.encryptedData)
              // that.queryWxUserInfo();
              that.setData({
                nickName: res.userInfo.nickName,
                avatarUrl: res.userInfo.avatarUrl
              })
            }
          })
        }
      }
    })

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  onChange(event) {
    console.log(event.detail);
    if (event.detail == 0) {
      wx.redirectTo({
        url: '../translation/index?active=' + event.detail,
      })
    }
    if (event.detail == 1) {
      wx.redirectTo({
        url: '../news/news?active=' + event.detail,
      })

    }
    if (event.detail == 2) {
      wx.redirectTo({
        url: '../person/person?active=' + event.detail,
      })
    }
  },
  bindGetUserInfo(e) {
    var that = this
    console.log(app.globalData.flag)
    if (e.detail.userInfo != null) {
      that.setData({
        nickName: e.detail.userInfo.nickName,
        avatarUrl: e.detail.userInfo.avatarUrl,
      })

    }
    if (app.globalData.flag != true) {
      wx.getUserInfo({
        success(res) {
          console.log('encryptedData：' + res.encryptedData)
          wx.request({
            url: app.globalData.urlPath + '/WxUser/addwxuser',
            data: {
              nickName: res.userInfo.nickName,
              avatarUrl: res.userInfo.avatarUrl,
              city: res.userInfo.city,
              country: res.userInfo.country,
              gender: res.userInfo.gender,
              language: res.userInfo.language,
              province: res.userInfo.province
            },
            method: 'POST',
            header: {
              'content-type': 'application/json',
              'Cookie': 'JSESSIONID=' + app.globalData.sessionid
            },
            success: function(res) {
              console.log(res.data)
              wx.redirectTo({
                url: '../person/person?active=' + 2,
              })
            }
          })
        }
      })
    }
  },
  queryWxUserInfo: function() {
    console.log(app.globalData.openid)
    wx.request({
      url: app.globalData.urlPath + '/WxUser/userbyopenid',
      data: {
        openId: app.globalData.openid
      },
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        console.log(res.data)
        app.globalData.flag = res.data.success
      }
    })
  },
})