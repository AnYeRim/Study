
// MyFirstDialogDlg.h : ��� ����
//

#pragma once
#include "afxwin.h"


// CMyFirstDialogDlg ��ȭ ����
class CMyFirstDialogDlg : public CDialogEx
{
// �����Դϴ�.
public:
	CMyFirstDialogDlg(CWnd* pParent = NULL);	// ǥ�� �������Դϴ�.

// ��ȭ ���� �������Դϴ�.
	enum { IDD = IDD_MYFIRSTDIALOG_DIALOG };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV �����Դϴ�.


// �����Դϴ�.
protected:
	HICON m_hIcon;

	// ������ �޽��� �� �Լ�
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
