
// MyFirstDialogDlg.h : 헤더 파일
//

#pragma once
#include "afxwin.h"


// CMyFirstDialogDlg 대화 상자
class CMyFirstDialogDlg : public CDialogEx
{
// 생성입니다.
public:
	CMyFirstDialogDlg(CWnd* pParent = NULL);	// 표준 생성자입니다.

// 대화 상자 데이터입니다.
	enum { IDD = IDD_MYFIRSTDIALOG_DIALOG };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV 지원입니다.


// 구현입니다.
protected:
	HICON m_hIcon;

	// 생성된 메시지 맵 함수
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnBnClickedButtonLoad();
//	afx_msg void OnBnKillfocusButtonLoad();
	CString m_strContent;
	afx_msg void OnBnClickedButtonSave();
	afx_msg void OnBnClickedButtonAdd();
	CListBox m_listbox_content;
	afx_msg void OnBnClickedButtonRemove();
};
